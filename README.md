# Distributed-Subscription-System-Application


**Overview:**
This Java-based project implements a distributed subscription system, allowing clients to subscribe, unsubscribe, log in, and log out across multiple servers. The system ensures synchronization of subscription data among servers for consistency.

**Key Features:**
- **Server Management:** Server1, Server2, and Server3 handle subscription status, user logins, and data synchronization between servers.
- **Client Interaction:** Clients connect to a randomly selected server to perform subscription and login actions based on a simple menu.
- **Data Synchronization:** Regularly synchronizes subscription data between servers to maintain a consistent state.
- **Object Serialization:** Utilizes Java object serialization for exchanging complex data structures between servers.
- **User-Friendly Client:** Provides a straightforward command-line interface for users to interact with the subscription system.

**Usage:**
1. Run the Server1 application on port 5001.
2. Run additional instances of Server2 and Server3 on ports 5004 and 5008, respectively.
3. Execute the Client application, which randomly selects a server and allows users to perform subscription-related actions.

Youtube: https://youtu.be/NqTfXU1jL_c
