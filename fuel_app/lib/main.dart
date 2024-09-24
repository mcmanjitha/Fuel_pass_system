import 'package:flutter/material.dart';
import 'package:fuel_app/src/screens/dashboard.dart';
import 'package:fuel_app/src/screens/login_screen.dart';
import './src/screens/qr_scanner.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Dashboard(),
    );
  }
}
