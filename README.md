<h3 align="center">Data-scraper for Reddit</h3>
  <p align="center">
    Data-scraper for reddit made using java and sqlite. 
  </p>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

* Data-Scraper for Reddit is a GUI-based scraping tool that allows users to scrape data from Reddit using the official API from Reddit
* The GUI is implemented using Java Swing and SQLite for storing user data
* Features 10+ filters and a dedicated sorting panel
* Results are filtered from upto 250 pages
* Final results can be neatly saved in a CSV format


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)
* ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
### Prerequisites

* Java

Linux/Mac

You can install java through [Homebrew](https://brew.sh/):
  ```sh
  brew install java 
  ```

Windows

Download Java 18 from [Oracle](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
and follow the instructions from installer. Make sure you add the installation directory to your system path.

### Installation

1. Go to [Reddit](https://www.reddit.com/prefs/apps) to create a free API app
2. Select a name such as "dataScraper"
3. Select "script"
4. Leave the description and about URL as blank
5. Use http://localhost:8080 for your redirect URL
6. Create the app
7. Next download the latest jar file from [Releases](https://github.com/amoghmc/dataScraper/releases)
8. Move the jar file to a new folder
9. Run using the following command using the terminal,
   ```sh
   java -jar RedditDataScraper-[VERSION].jar 
   ```
10. Click on "Register a new account"
11. Enter your details and use client_id and client_secret from your API app
12. For more details visit [Oauth2](https://github.com/reddit-archive/reddit/wiki/oauth2)
<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Examples:
* Selecting all posts whose title contains the keywords "putin" and "ukraine" from the subreddit "worldnews"

![example_1](Screenshots/example_1.png?raw=true)
[CSV Result](Results/result_1.csv)

* Selecting all posts from the subreddit Coronavirus that contains numbers in the title. Results must also have a minimum score of 1000, and minimum comment count of 100.
Results are finally sorted by their title.

![example_1](Screenshots/example_2.png?raw=true)
[CSV Result](Results/result_2.csv)

* Selecting all controversial posts from all subreddits. 

![example_1](Screenshots/example_3.png?raw=true)
[CSV Result](Results/result_3.csv)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE.txt -->
## License

Distributed under the MIT License. See `LICENSE.md` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [JRAW - A Java Reddit API Wrapper](https://github.com/mattbdean/JRAW)
* [JForm Designer - A professional GUI designer for Java Swings](https://www.formdev.com/)
* [GitHub Readme Template](https://github.com/othneildrew/Best-README-Template)

<p align="right">(<a href="#top">back to top</a>)</p>
