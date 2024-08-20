import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: PreferredSize(
          preferredSize: const Size(100, 70),
          child: AppBar(
            flexibleSpace: Container(
              padding: const EdgeInsets.only(left: 8.0, right: 8.0, top: 30.0),
              decoration: const BoxDecoration(
                gradient: LinearGradient(
                  colors: [
                    Color.fromARGB(255, 242, 243, 243),
                    Color.fromARGB(255, 94, 93, 93)
                  ],
                  begin: Alignment.topLeft,
                  end: Alignment.bottomRight,
                ),
              ),
              child: Row(
                children: [
                  Container(
                    margin: const EdgeInsets.only(left: 5.0),
                    padding: const EdgeInsets.only(
                        top: 8.0, right: 3.0, bottom: 8.0, left: 8.0),
                    child:
                        Image.asset('assets/logo.png'), // Add your image here
                  ),
                  const SizedBox(width: 16.0),
                  const Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        'National Fuel Pass System',
                        style: TextStyle(
                            fontSize: 16.0,
                            color: Color.fromARGB(255, 101, 1, 33)),
                      ),
                      Text(
                        'ජාතික ඉන්ධන සැපයුම් සේවාව',
                        style: TextStyle(
                            fontSize: 12.0,
                            color: Color.fromARGB(255, 101, 1, 33)),
                      ),
                      Text(
                        'தேசிய எரிபொருள் விநியோக சேவை',
                        style: TextStyle(
                            fontSize: 12.0,
                            color: Color.fromARGB(255, 101, 1, 33)),
                      )
                    ],
                  )
                ],
              ),
            ),
          ),
        ),
        body: const LoginPage(),
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
      ),
    );
  }
}

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
                  color: Color.fromARGB(255, 101, 1, 33),
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
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        // Perform the login logic here
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(content: Text('Logging in...')),
                        );
                      }
                    },
                    child: const Text(
                      'Login',
                      style: TextStyle(color: Color.fromARGB(255, 101, 1, 33)),
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
                              color: Color.fromARGB(255, 150, 149, 149)),
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
                          color: Color.fromARGB(255, 150, 149, 149),
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
    );
  }
}
