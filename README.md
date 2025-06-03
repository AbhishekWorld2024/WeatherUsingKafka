<h1>🌦️ Weather Kafka Streaming with Spring Boot</h1>

<p>This project is a real-time weather streaming application built with <strong>Spring Boot</strong> and <strong>Apache Kafka</strong>. It fetches live weather data from the OpenWeatherMap API and publishes it as JSON messages to a Kafka topic. A consumer listens to this topic and logs the weather data for further processing or display.</p>

<h2>📂 Project Overview</h2>
<ul>
  <li><strong>WeatherController.java:</strong> Provides a REST endpoint to fetch weather for a city and trigger Kafka publishing.</li>
  <li><strong>WeatherProducer.java:</strong> Calls the OpenWeatherMap API for a given city and sends the weather data to a Kafka topic named <code>weather-data</code>.</li>
  <li><strong>WeatherConsumer.java:</strong> Listens to the <code>weather-data</code> Kafka topic and logs the consumed <code>WeatherData</code>.</li>
  <li><strong>KafkaConfig.java:</strong> Configures Kafka Producer with JSON serialization for <code>WeatherData</code> objects.</li>
  <li><strong>WeatherData.java:</strong> POJO representing the weather data model including city name, temperature, and timestamp.</li>
</ul>

<h2>🚀 How It Works</h2>
<ol>
  <li>Make a <code>GET</code> request to <code>/weather/{city}</code>.</li>
  <li>The controller delegates to <code>WeatherProducer</code> to fetch weather data from OpenWeatherMap.</li>
  <li>The producer sends this data as a JSON object to the <code>weather-data</code> Kafka topic.</li>
  <li><code>WeatherConsumer</code> listens to the topic and prints the incoming weather info.</li>
</ol>

<h2>📬 Sample Request</h2>

<pre><code>GET http://localhost:8080/weather/London</code></pre>

<h2>📨 Sample Output (Console)</h2>
<pre><code>Real-time Weather Sent: WeatherData{City='London', temperature=15.5, timestamp=1654356789123}
Consumed: WeatherData{City='London', temperature=15.5, timestamp=1654356789123}
</code></pre>

<h2>🔧 Tech Stack</h2>
<ul>
  <li>Java 17+</li>
  <li>Spring Boot</li>
  <li>Apache Kafka</li>
  <li>Spring Kafka</li>
  <li>OpenWeatherMap API</li>
</ul>

<h2>📌 Kafka Details</h2>
<ul>
  <li><strong>Producer Topic:</strong> <code>weather-data</code></li>
  <li><strong>Consumer Group:</strong> <code>weather-group</code></li>
  <li><strong>Serialization:</strong> JSON (via <code>JsonSerializer</code> for WeatherData)</li>
</ul>

<h2>📝 Notes</h2>
<ul>
  <li>Ensure Kafka is running on <code>localhost:9092</code>.</li>
  <li>The API key for OpenWeatherMap must be valid (replace <code>API_KEY</code> if expired).</li>
  <li>Add a <code>RestTemplate</code> bean if not already configured in your main app.</li>
</ul>

<h2>💡 Example WeatherData Payload</h2>
<pre><code>{
  "city": "New York",
  "temperature": 22.4,
  "timestamp": 1654357890123
}</code></pre>
