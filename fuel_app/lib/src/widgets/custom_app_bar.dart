import 'package:flutter/material.dart';
import '../utils/constants.dart';

class CustomAppBar extends StatelessWidget {
  const CustomAppBar({super.key});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      flexibleSpace: Container(
        padding: const EdgeInsets.only(left: 8.0, right: 8.0, top: 30.0),
        decoration: const BoxDecoration(
          gradient: appBarBackgroundColor,
        ),
        child: Row(
          children: [
            Container(
              margin: const EdgeInsets.only(left: 5.0),
              padding: const EdgeInsets.only(
                  top: 8.0, right: 3.0, bottom: 8.0, left: 8.0),
              child: Image.asset('assets/logo.png'), // Add your image here
            ),
            const SizedBox(width: 16.0),
            const Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'National Fuel Pass System',
                  style: appBarLabelStyle,
                ),
                Text(
                  'ජාතික ඉන්ධන සැපයුම් සේවාව',
                  style: appBarLabelStyle,
                ),
                Text(
                  'தேசிய எரிபொருள் விநியோக சேவை',
                  style: appBarLabelStyle,
                )
              ],
            )
          ],
        ),
      ),
    );
  }
}
