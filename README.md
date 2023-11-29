# Keystroke
A Proof-Of-Concept for a secondary password authorization, utilizing biometric data. 

Passwords are security-by-obscurity; you've hidden your prize. But if someone knows the location, there is no security. 
Encryptions are a vault; you've protected it behind a wall. But given time or enough effort, the vault can be broken; furthermore, given the key, the vault can be opened and the security is gone. 
Biometrics, however, can be difficult to replicate, making them ideal as a login solution; however, they come with a downside, which is that they can be very complicated to implement. 

Keystroke is a representation of a new kind of security where biometric data (typing patterns) can be gathered by the user as they type their password; having typed that password many times, they will have developed a unique "signature" comprised of the timings between each keystroke that cannot be replicated unless the imposter had the same hand positions, frequently typed the same type of content (new media, software, or other broad category), AND knew the password long enough to have developed a typing pattern for it. Even then they will have minor differences that, if exceeding a standard deviation of a specified percentage, will fail. 

The aim of this software is not to replace passwords, but to enhance them, and make them personal. In this way, we can vastly increase security on existing platforms, using authorization methods people are already familiar with, and without being obtrusive or difficult to integrate. 
