import 'package:flutter/material.dart';
import 'package:fuel_app/src/widgets/custom_app_bar.dart';
import '../utils/constants.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class Dashboard extends StatefulWidget {
  final String beforeDollar;
  final String afterDollar;

  const Dashboard({
    Key? key,
    required this.beforeDollar,
    required this.afterDollar,
  }) : super(key: key);

  @override
  _DashboardScreenState createState() => _DashboardScreenState();
}

class _DashboardScreenState extends State<Dashboard> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _pumpedAmountController = TextEditingController();

  bool _isFormVisible = true;
  String _responseMessage = 'Loading...';

  @override
  void initState() {
    super.initState();
    _fetchQuotaData(); // Call the method to send the POST request
  }

  Future<void> _fetchQuotaData() async {
    final String url =
        'http://192.168.43.188:8080/quota/${widget.beforeDollar}';
    try {
      final response = await http.post(
        Uri.parse(url),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({'afterDollar': widget.afterDollar}),
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        setState(() {
          _responseMessage =
              '${data['quota']} ltrs'; // Update response message with quota
        });
      } else {
        setState(() {
          _responseMessage = 'Error: ${response.statusCode}';
        });
      }
    } catch (e) {
      setState(() {
        _responseMessage = 'Error: $e';
      });
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
                'Available Fuel Quota ...',
                style: TextStyle(
                  color: maroon,
                  fontWeight: FontWeight.bold,
                  fontSize: 24.0, // Font size for the title
                ),
              ),
            ),
          ),
          Container(
            padding: const EdgeInsets.only(
                top: 40.0,
                bottom: 16.0), // Top and bottom padding for the title area
            //color: Colors.teal[400],
            child: Center(
              child: Text(
                _responseMessage,
                style: const TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 50.0, // Font size for the title
                ),
              ),
            ),
          ),
          if (_isFormVisible)
            Expanded(
                child: Padding(
              padding: const EdgeInsets.all(46.0),
              child: Form(
                key: _formKey,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: <Widget>[
                    TextFormField(
                      controller: _pumpedAmountController,
                      decoration: const InputDecoration(
                        labelText: 'Pumped Amount',
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'Please enter the pumped amount';
                        }
                        return null;
                      },
                    ),
                    const SizedBox(height: 32.0),
                    ElevatedButton(
                      onPressed: () async {
                        if (_formKey.currentState!.validate()) {
                          String pumpedAmount = _pumpedAmountController.text;
                          // Prepare the URL and body for the request
                          String url =
                              'http://192.168.43.188:8080/update/${widget.beforeDollar}';
                          Map<String, dynamic> body = {
                            'pumpedAmount': pumpedAmount
                          };
                          // Perform the login logic here
                          // Send the POST request
                          try {
                            final response = await http.post(
                              Uri.parse(url),
                              headers: {"Content-Type": "application/json"},
                              body: json.encode(body),
                            );
                            print("hello");
                            if (response.statusCode == 200) {
                              // Successfully received a response
                              // Optionally handle the response data here
                              ScaffoldMessenger.of(context).showSnackBar(
                                const SnackBar(
                                    content: Text('Update successful!')),
                              );

                              // Navigate back to Home widget
                              Navigator.pop(
                                  context); // Use pop to return to the previous screen
                            } else {
                              // Handle error response
                              ScaffoldMessenger.of(context).showSnackBar(
                                SnackBar(
                                    content: Text(
                                        'Failed to update: ${response.reasonPhrase}')),
                              );
                            }
                          } catch (e) {
                            // Handle exceptions
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(content: Text('Error occurred: $e')),
                            );
                          }
                        }
                      },
                      child: const Text(
                        'Send',
                        style: TextStyle(color: maroon),
                      ),
                    ),
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
