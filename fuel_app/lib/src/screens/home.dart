import 'package:flutter/material.dart';
import 'package:fuel_app/src/screens/qr_scanner.dart';
import 'package:fuel_app/src/widgets/custom_app_bar.dart';
import '../utils/constants.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<Home> {
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
      body: Container(
        color: white,
        child: Column(
          children: [
            // QR code image at the top
            const SizedBox(height: 76.0),
            Padding(
              padding: const EdgeInsets.only(top: 20.0),
              child: Center(
                child: Container(
                  height: 250,
                  width: 250,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(20), // Rounded corners
                    border: Border.all(
                      color: lightgrey, // Border color
                      width: 2, // Border width
                    ),
                  ),
                  child: ClipRRect(
                    borderRadius:
                        BorderRadius.circular(20), // Match the border radius
                    child: Image.asset(
                      'assets/qr_code.png', // Path to your QR code image asset
                      fit:
                          BoxFit.cover, // This will help with fitting the image
                    ),
                  ),
                ),
              ),
            ),

            const SizedBox(height: 60),

            // Button to scan QR code
            ElevatedButton(
              onPressed: () {
                // Navigate to the QRScannerScreen
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => const QRScannerScreen(),
                  ),
                );
              },
              child: const Text(
                'Scan QR Code',
                style: TextStyle(
                  fontSize: 22.0, // Increase this value to make the font larger
                ),
              ),
            ),
          ],
        ),
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
