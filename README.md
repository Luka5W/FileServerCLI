# FileServerCLI

_A CLI for the [FileServer](https://github.com/Luka5W/FileServer) for administrative purposes_

**This project is still work in progress!**

## About

The program uses the http(s) protocol to interact with the server.

This includes:
- File access
- File metadata access
- User management

## Documentation

- The [API](https://luka5w.github.io/FileServer/api/FileServer.postman_collection.json) of the FileServer is documented with [Postman](https://www.postman.com)
- [JavaDoc](https://luka5w.github.io/FileServerCLI/javadoc/)

### Installation & Usage

1. Download the jar from the [releases](https://github.com/Luka5W/FileServerCLI/releases/latest).
2. Execute the program with `java -jar FileServerCLI_[version].jar`.

To get the version, execute the program with the `-v` flag, for all arguments with the `-h` flag.

**Usage**:
- General:
  - `?`: Display help.
  - `c user@https://example.com:8443`: Connects to a server (after querying password).
  - `v`: Gets the API versions, supported by the server.
- User Management:
  - `s` (self)
    - `-i`: Gets information about your account.
    - `-p`: Opens a dialog to change the password.
    - `-d`: Deletes your account.
  - `o` (other)
    - `-l [-a]`: (Admin required): Lists all users. When the `-a` flag is set it lists all users with their data.
    - `-c`: (Admin required): Opens a dialog to add a new user.
    - `-m`: (Admin required): Opens a dialog to modify an existing user.
    - `-d`: (Admin required): Deletes an existing user.
- File Management:
  - `f` (file)
    - `-l [-a]`: Lists all own files. When the `-a` flag is set it lists all own files with their metadata.
    - `-g <id> [<output>]`: Gets the content of a file. When an output file is passed, it writes the content to a file.
    - `-G <id> [<output>]`: Gets the metadata of a file. When an output file is passed, it writes the metadata to a file.
    - `-c [<input>]`: Creates a new file. When the input file is passed (must be a valid json file), it sends the content with the request.
    - `-m <id> <input>`: Modifies the content of a new file.
    - `-d <id>`: Deletes the file.