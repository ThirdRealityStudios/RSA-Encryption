# RSA encryption algorithm (Java)

**This is a simple example of an implementation for the RSA encryption and decryption.**

It is fully working but beware of long calculation times as it uses only simple algorithms for calculating and retrieving prime numbers.

Saving prime numbers on your hard-disk or simply connecting the RSA algorithm to a database (with billions of pre-defined prime numbers) would definitively accelerate the progress.

Also note that this example does not make use of square and multiply in order to prevent overflows while encrypting.
This implementation just makes use of the Java internal class BigInteger.