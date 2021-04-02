# RSA encryption algorithm (Java)

This is an example of a simple implementation of the RSA encryption.

Note that this example does not make use of square and multiply or similar exponential algorithm to
prevent overflows.
Instead I just implemented the internal Java class BigInteger which allows you to provide values (cleartext symbol) up
to ~515 (at least on my system) without failure.