# SysUpdateParser
I've restructured the SysUpdate API to save the update data to a database. For new data, a parser was written, running daily to ensure recent updates will be made to said database.

[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/F1F51BI4D)

## Important things first
This service connects to other servers, in order to gather information. These are:
- Nintendo's japanese support pages
- SONY's official update servers

I am not affiliated with both companies in any way, regarding this project.
If either Nintendo (Nintendo Co. Ltd. or related) or SONY (Sony Computer Entertainment or related) want's this project to be closed, please notify me about it (and provide a proof of beeing a real employee of the company in question). I carefully checked this project and can state, that this project (parser and API) won't publish confidential information, just the version number and the date it was published. This project does not circumvent any copyright related protection schemes. The sources used can be accessed by anyone opening the urls on a browser(in SONY's case) and viewing the support pages(in Nintendo's case).

## Description
SysUpdateParser is a Java application gathering data on system updates from variopus platforms.
It collects them from official sources and sends them to my SysUpdate Database, ready to be used within other services and apps, with version 2 of the SysUpdateAPI.
The recieved data contains the firmware version (for example 11.9.0-42) and the date, the update was published.

## Usage
Run the "SysUpdateParser.jar" if you also want to parse those data and save it to your own database.
Open it with with the following two arguments: "server" and "pass". The Server should point to a server handling the data sent from the parser and it authenticates itself with a password.
You can get data for the following platforms:
  - Nintendo Switch
  - Nintendo 3DS (Updates are mostly the same for all old3DS and new3DS devices)
  - Wii U (Should mostly be the same between all regions)
  - PS Vita
  - PS4
