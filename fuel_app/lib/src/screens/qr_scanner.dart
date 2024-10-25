import 'package:flutter/material.dart';
import 'package:fuel_app/src/screens/dashboard.dart';
import 'package:qr_code_scanner/qr_code_scanner.dart';

class QRScannerScreen extends StatefulWidget {
  const QRScannerScreen({super.key});

  @override
  State<StatefulWidget> createState() => _QRScannerScreenState();
}

class _QRScannerScreenState extends State<QRScannerScreen> {
  final GlobalKey qrKey = GlobalKey(debugLabel: 'QR');
  QRViewController? controller;
  Barcode? result;

  @override
  void reassemble() {
    super.reassemble();
    if (controller != null) {
      controller!.pauseCamera();
      controller!.resumeCamera();
    }
  }

  @override
  void dispose() {
    controller?.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('QR Scanner'),
        actions: [
          IconButton(
            icon: const Icon(Icons.flash_on),
            onPressed: () {
              controller?.toggleFlash();
            },
          ),
          IconButton(
            icon: const Icon(Icons.settings),
            onPressed: () {
              // Handle settings button press
            },
          ),
        ],
      ),
      body: Stack(
        children: [
          QRView(
            key: qrKey,
            onQRViewCreated: _onQRViewCreated,
          ),
          // Top overlay
          Positioned(
            top: 0,
            left: 0,
            right: 0,
            height: MediaQuery.of(context).size.height * 0.25,
            child: Container(
              color: Colors.black.withOpacity(0.6),
            ),
          ),
          // Bottom overlay
          Positioned(
            bottom: 0,
            left: 0,
            right: 0,
            height: MediaQuery.of(context).size.height * 0.25,
            child: Container(
              color: Colors.black.withOpacity(0.6),
            ),
          ),
          // Left overlay
          Positioned(
            top: MediaQuery.of(context).size.height * 0.25,
            bottom: MediaQuery.of(context).size.height * 0.25,
            left: 0,
            width: MediaQuery.of(context).size.width * 0.25,
            child: Container(
              color: Colors.black.withOpacity(0.6),
            ),
          ),
          // Right overlay
          Positioned(
            top: MediaQuery.of(context).size.height * 0.25,
            bottom: MediaQuery.of(context).size.height * 0.25,
            right: 0,
            width: MediaQuery.of(context).size.width * 0.25,
            child: Container(
              color: Colors.black.withOpacity(0.6),
            ),
          ),
          // Centered square brackets
          Align(
            alignment: Alignment.center,
            child: Container(
              width: MediaQuery.of(context).size.width * 0.5,
              height: MediaQuery.of(context).size.width * 0.5,
              decoration: const BoxDecoration(
                border: Border(
                  top: BorderSide(color: Colors.white, width: 4.0),
                  left: BorderSide(color: Colors.white, width: 4.0),
                  right: BorderSide(color: Colors.white, width: 4.0),
                  bottom: BorderSide(color: Colors.white, width: 4.0),
                ),
              ),
            ),
          ),
          // Text at the bottom inside the focused area
          const Align(
            alignment: Alignment(0, 0.8),
            child: Text(
              'Point the camera at the QR code',
              style: TextStyle(color: Colors.white, fontSize: 16),
              textAlign: TextAlign.center,
            ),
          ),
          // Bottom button
          Align(
            alignment: Alignment.bottomCenter,
            child: Padding(
              padding: const EdgeInsets.all(20.0),
              child: ElevatedButton(
                onPressed: () {
                  // Navigate to history screen
                },
                child: const Text('HISTORY'),
              ),
            ),
          ),
        ],
      ),
    );
  }

  void _onQRViewCreated(QRViewController controller) {
    setState(() {
      this.controller = controller;
    });

    controller.scannedDataStream.listen((scanData) {
      setState(() {
        result = scanData;
      });

      // Print the result to the VS Code console
      print('Scanned QR Code: ${scanData.code}');

      if (scanData.code != null) {
        // Extract the substrings before and after the '$' sign
        String scannedCode = scanData.code!;
        List<String> parts = scannedCode.split('\$');

        String beforeDollar = '';
        String afterDollar = '';

        if (parts.length == 2) {
          beforeDollar = parts[0].trim(); // Extract before the '$' sign
          afterDollar = parts[1].trim(); // Extract after the '$' sign

          // Print the extracted values
          print(beforeDollar);
          print(afterDollar);
        } else {
          print('Invalid QR code format. Expected format: "before".');
        }

        controller.pauseCamera(); // Optional: pause the camera after scanning
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(
              builder: (context) => Dashboard(
                    beforeDollar: beforeDollar,
                    afterDollar: afterDollar,
                  )),
        );
      }
    });
  }

  // void _onQRViewCreated(QRViewController controller) {
  //   setState(() {
  //     this.controller = controller;
  //   });
  //   controller.scannedDataStream.listen((scanData) {
  //     setState(() {
  //       result = scanData;
  //     });
  //     // Print the result to the VS Code console
  //     print('Scanned QR Code: ${scanData.code}');

  //     if (scanData.code != null) {
  //       controller.pauseCamera(); // Optional: pause the camera after scanning
  //       Navigator.pushReplacement(
  //         context,
  //         MaterialPageRoute(builder: (context) => const Dashboard()),
  //       );
  //     }
  //   });
  // }
}
