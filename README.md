# Cryptography Algorithms in Java

This project contains implementations of several cryptography algorithms in Java. Each class represents a different cipher or encryption technique, and the `Driver` class demonstrates their usage. Below is a summary of each file and the ciphers they implement.

## Table of Contents
- [AES.java](#aesjava)
- [Autokey.java](#autokeyjava)
- [Caesar.java](#caesarjava)
- [DES.java](#desjava)
- [Driver.java](#driverjava)
- [RailFence.java](#railfencejava)
- [RSA.java](#rsajava)
- [UserInterface.java](#userinterfacejava)

## AES.java
**Type**: Symmetric Key Encryption  
**Algorithm**: AES (Advanced Encryption Standard)

This file implements the AES encryption algorithm, which is a widely used symmetric key cipher. AES encrypts data in blocks of 128 bits using a key of 128, 192, or 256 bits. It is known for its security and efficiency in various applications.

## Autokey.java
**Type**: Polyalphabetic Substitution Cipher  
**Algorithm**: Autokey Cipher

The Autokey cipher is a polyalphabetic substitution cipher that uses a keyword, followed by the plaintext itself, to form the encryption key. This class provides methods to encrypt and decrypt messages using the Autokey cipher.

## Caesar.java
**Type**: Simple Substitution Cipher  
**Algorithm**: Caesar Cipher

The Caesar cipher is one of the oldest and simplest encryption techniques. It shifts each letter in the plaintext by a fixed number of positions down the alphabet. This class allows for the encryption and decryption of text using a specified shift value.

## DES.java
**Type**: Symmetric Key Encryption  
**Algorithm**: DES (Data Encryption Standard)

This file implements the DES algorithm, which is an older symmetric key cipher that operates on blocks of 64 bits. Although it has been largely replaced by AES, DES is still studied for its historical significance and educational purposes.

## Driver.java
**Type**: Main Application Driver

The `Driver` class serves as the main entry point for the application. It demonstrates the usage of the different encryption and decryption algorithms provided in this project, allowing users to test and understand how each cipher works.

## RailFence.java
**Type**: Transposition Cipher  
**Algorithm**: Rail Fence Cipher

The Rail Fence cipher is a form of transposition cipher that rearranges the letters of the plaintext to create the ciphertext. This class provides methods for encrypting and decrypting messages using the Rail Fence technique.

## RSA.java
**Type**: Asymmetric Key Encryption  
**Algorithm**: RSA (Rivest-Shamir-Adleman)

The RSA algorithm is an asymmetric encryption technique that uses a pair of keys (public and private) for encryption and decryption. This class implements RSA, providing methods for key generation, encryption, and decryption.

## UserInterface.java
**Type**: User Interface

The `UserInterface` class provides a simple command-line interface for interacting with the different encryption and decryption methods. It allows users to input plaintext, choose an encryption method, and see the resulting ciphertext.

## How to Run
To run the project, compile the Java files and execute the `Driver` class, which will guide you through the available encryption options and demonstrate the functionality of each cipher.

```bash
javac *.java
java Driver
