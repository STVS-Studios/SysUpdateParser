# SysUpdateParser
I've restructured the SysUpdate API to save the update data to a database. For new data, a parser was written, running daily to ensure recent updates will be made to said database.

## Important things first
This service connects to other servers, in order to gather information. These are:
- Nintendo's japanese support pages

I am not affiliated with both companies in any way, regarding this project.
If Nintendo wants this project to be closed, please notify me about it (and provide a proof of beeing a real employee of the company in question). I carefully checked this project and can state, that this project doesn't contain URLs of update data and other confidential information, just the version number and the date it was published.

## Description
SysUpdateParser is a Java application gathering data on system updates from variopus platforms.
It collects them from official sources and sends them to my SysUpdate Database, ready to be used within other services and apps, with version 2 of the SysUpdateAPI.
The recieved data contains the firmware version (for example 11.9.0-42) and the date, the update was published.

## Usage
Run the "SysUpdateParser.jar" if you also want to parse those data and save it to your own database.
Open it with with the following two arguments: "server" and "pass". The Server points to a server handling the data sent from the parser and it authenticates itself with a password.
You can get data for the following platforms:
  - Nintendo Switch
  - Nintendo 3DS
  - Wii U
