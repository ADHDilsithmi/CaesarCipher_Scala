/*The Caesar cipher is one of the earliest known and simplest ciphers.
It is a type of substitution cipher in which each letter in the plaintext is 'shifted' a certain number of places down the alphabet.
For example, with a shift of 1, A would be replaced by B, B would become C, and so on.
The method is named after Julius Caesar, who apparently used it to communicate with his generals.

Implement Encryption and Decryption functions of Caesar cipher.
Then implement a Cipher function which take Encryption and Decryption functions to process the data.*/

//Index - 19000324

import scala.io.StdIn.readLine
object caesarCipher extends App{

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
  val key = 2

  val encrypt = (c:Char, key:Int, alphabet:String) => alphabet((alphabet.indexOf(c.toUpper) + key)%alphabet.size)
  val decrypt = (c:Char, key:Int, alphabet:String) => alphabet((alphabet.indexOf(c.toUpper) - key + alphabet.size)%alphabet.size)

  val cipher = (algo:(Char, Int, String) => Char, message:String, key:Int, alphabet:String) => message.map(algo(_, key, alphabet))

  println("Do you want to encrypt or decrypt")
  val choise = readLine()

  if(choise == "encrypt"){
    println("Enter your message to encrypt : ")         //I miss my university life
    val string1 = readLine()

    val encryptedText = cipher(encrypt, string1, key, alphabet)
    val decryptedText = cipher(decrypt, encryptedText, key, alphabet)

    printf("Encrypted message: %s\n",encryptedText)         //KBOKUUBO BWPKXGTUKV BNKHG
    printf("Decrypted message: %s\n",decryptedText)         //I MISS MY UNIVERSITY LIFE
  }
  else if(choise == "decrypt"){
    println("Enter your message to decrypt: ")          //KBOKUUBO BWPKXGTUKV BNKHG
    val string2 = readLine()

    val decryptedText = cipher(decrypt, string2, key, alphabet)
    val encryptedText = cipher(encrypt, decryptedText, key, alphabet)

    printf("Decrypted message: %s\n",decryptedText)         //I MISS MY UNIVERSITY LIFE
    printf("Encrypted message: %s\n",encryptedText)         //KBOKUUBO BWPKXGTUKV BNKHG
  }
  else{
    println("Invalid input. Please try again")
  }

}