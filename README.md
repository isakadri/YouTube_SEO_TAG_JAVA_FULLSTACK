🚀 YouTube SEO Tag Generator & Thumbnail Downloader
Java Full-Stack Project (Spring Boot + Thymeleaf)

📌 Project Description

This is a Java Full-Stack Web Application built using Spring Boot, Thymeleaf, JPA (Hibernate) that helps YouTube creators generate SEO-optimized tags, copy tags easily, and download high-quality video thumbnails using the YouTube Data API.
The application improves video discoverability, search ranking, and engagement by providing smart SEO tag suggestions and thumbnail extraction in one place.

🎯 Key Features

✅ Generate YouTube SEO Tags automatically
✅ Copy SEO tags with one click
✅ Download YouTube video thumbnails (Max / High / Medium quality)
✅ Fetch video details using YouTube Data API v3
✅ Clean & responsive UI using Thymeleaf + Bootstrap
✅ Store search history using JPA & MySQL
✅ Fast & secure backend with Spring Boot

🛠️ Tech Stack
🔹 Backend

-  Java (JDK 17+)
-  Spring Boot
-  Spring MVC
-  Spring Data JPA (Hibernate)
-  REST APIs

🔹 Frontend
-  Thymeleaf
-  HTML5
-  CSS3
-  Bootstrap
-  JavaScript

🔹 Database
-  MySQL

🔹 External API
-  YouTube Data API v3

📂 Project Modules

🔹 YouTube Video Search
🔹 SEO Tag Generator
🔹 Copy SEO Tags
🔹 Thumbnail Downloader
🔹 API Integration
🔹 Database Persistence
⚙️ Application Workflow
<pre><pre> User enters YouTube Video URL / Video ID ↓ Spring Boot Controller receives request ↓ YouTube Data API fetches video details ↓ SEO tags are generated automatically ↓ User can copy tags or download thumbnails </pre></pre>

🔐 YouTube API Configuration

-  Create a project in Google Cloud Console
-  Enable YouTube Data API v3
-  Generate API Key
-  Add API key in application.properties

  ▶️ How to Run the Project
🔹 Prerequisites

-  Java 17+
-  Maven
-  MySQL

Internet connection (for YouTube API)

🔹 Steps
<pre><pre> git clone https://github.com/your-username/youtube-seo-tag-generator.git cd youtube-seo-tag-generator mvn clean install mvn spring-boot:run </pre></pre>

Open browser:

<pre><pre> http://localhost:8080 </pre></pre>

<pre><pre> youtube.api.key=YOUR_API_KEY_HERE </pre></pre>
