import 'package:flutter/material.dart';
import 'package:fuel_app/src/widgets/custom_app_bar.dart';
import '../utils/constants.dart';

class Dashboard extends StatefulWidget {
  const Dashboard({super.key});

  @override
  _DashboardScreenState createState() => _DashboardScreenState();
}

class _DashboardScreenState extends State<Dashboard> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _pumpedAmountController = TextEditingController();

  bool _isFormVisible = true;

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
            child: const Center(
              child: Text(
                '25.0 ltrs',
                style: TextStyle(
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
                      onPressed: () {
                        if (_formKey.currentState!.validate()) {
                          // Perform the login logic here
                          setState(() {
                            _isFormVisible = true;
                          });
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(content: Text('Sending ...')),
                          );
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
