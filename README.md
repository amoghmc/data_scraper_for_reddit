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

* Data-Scraper for Reddit is a GUI-based web scraping tool that allows users to scrape data using the official API from Reddit.
* The GUI is implemented using Java Swings and SQLite for storing user data.
* Features 10+ filters and a dedicated sorting panel.


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* Java 18
* SQLite

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

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

Examples:
* Selecting all posts whose title contains the keywords "putin" and "ukraine" from the subreddit "worldnews"
  ![example_1](Screenshots/example_1.png?raw=true)
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



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/amoghmc/dataScraper.svg?style=for-the-badge
[contributors-url]: https://github.com/amoghmc/dataScraper/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/amoghmc/dataScraper.svg?style=for-the-badge
[forks-url]: https://github.com/amoghmc/dataScraper/network/members
[stars-shield]: https://img.shields.io/github/stars/amoghmc/dataScraper.svg?style=for-the-badge
[stars-url]: https://github.com/amoghmc/dataScraper/stargazers
[issues-shield]: https://img.shields.io/github/issues/amoghmc/dataScraper.svg?style=for-the-badge
[issues-url]: https://github.com/amoghmc/dataScraper/issues
[license-shield]: https://img.shields.io/github/license/amoghmc/dataScraper.svg?style=for-the-badge
[license-url]: https://github.com/amoghmc/dataScraper/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 