import 'package:flutter/material.dart';
import 'package:fuel_app/src/screens/home.dart';
import 'package:fuel_app/src/widgets/custom_app_bar.dart';
import '../utils/constants.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'dart:convert';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  LoginScreenState createState() => LoginScreenState();
}

class LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  // Initialize secure storage
  final FlutterSecureStorage _storage = FlutterSecureStorage();

  // Function to send POST request for login validation
  Future<bool> _validateLogin(String username, String password) async {
    final url = Uri.parse('http://192.168.43.188:8080/login');
    // Create the POST request body
    final body = jsonEncode({
      'username': username,
      'password': password,
    });

    try {
      // Send the POST request
      final response = await http.post(
        url,
        headers: {'Content-Type': 'application/json'},
        body: body,
      );

      // Check if the response is successful
      if (response.statusCode == 200) {
        // Parse the response if needed
        final responseData = jsonDecode(response.body);
        print(responseData);
        if (responseData['success'] == true) {
          return true; // Login successful
        } else {
          return false; // Invalid credentials
        }
      } else {
        // Handle error response codes
        return false;
      }
    } catch (e) {
      // Handle any exceptions or errors
      print('Error during login request: $e');
      return false;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: const PreferredSize(
        preferredSize: Size(100, 70),
        child: CustomAppBar(),
      ),
      body: Column(
        children: [
          Container(
            padding: const EdgeInsets.only(
                top: 40.0,
                bottom: 16.0), // Top and bottom padding for the title area
            //color: Colors.teal[400],
            child: const Center(
              child: Text(
                'Login',
                style: TextStyle(
                  color: maroon,
                  fontWeight: FontWeight.bold,
                  fontSize: 24.0, // Font size for the title
                ),
              ),
            ),
          ),
          Expanded(
              child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: <Widget>[
                  TextFormField(
                    controller: _usernameController,
                    decoration: const InputDecoration(
                      labelText: 'Username',
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter your username';
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 16.0),
                  TextFormField(
                    controller: _passwordController,
                    decoration: const InputDecoration(
                      labelText: 'Password',
                    ),
                    obscureText: true, // To hide the password
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter your password';
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 32.0),
                  ElevatedButton(
                    onPressed: () async {
                      if (_formKey.currentState!.validate()) {
                        // Perform the login logic here
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(content: Text('Logging in...')),
                        );
                        // Perform login validation
                        bool isValid = await _validateLogin(
                          _usernameController.text,
                          _passwordController.text,
                        );
                        print(isValid);
                        if (isValid) {
                          // If login is valid, navigate to Home
                          print('valid');
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => const Home()),
                          );
                        } else {
                          // If login fails, show error message
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(
                                content: Text('Invalid credentials')),
                          );
                        }
                      }
                    },
                    child: const Text(
                      'Login',
                      style: TextStyle(color: maroon),
                    ),
                  ),
                  const SizedBox(
                    height: 50.0,
                  ),
                  Row(
                    children: [
                      Expanded(
                        child: Divider(
                          color: Colors.grey[600],
                          thickness: 0.5,
                        ),
                      ),
                      const Padding(
                        padding: EdgeInsets.symmetric(horizontal: 8.0),
                        child: Text(
                          'OR',
                          style: TextStyle(
                              fontSize: 12.0,
                              fontWeight: FontWeight.bold,
                              color: grey),
                        ),
                      ),
                      Expanded(
                        child: Divider(
                          color: Colors.grey[600],
                          thickness: 0.5,
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 16.0),
                  Center(
                    child: TextButton(
                      onPressed: () {
                        // Navigator.push(
                        //   context,
                        //   MaterialPageRoute(
                        //     builder: (context) => const CreateAccountPage(),
                        //   ),
                        // )
                      },
                      child: const Text(
                        'Create Account',
                        style: TextStyle(
                          color: grey,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                  )
                ],
              ),
            ),
          ))
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.settings),
            label: 'Settings',
          ),
        ],
      ),
    );
  }
}
