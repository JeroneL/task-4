const apiKey = "94af0091795d61d4bd2d116fb7966b38";

const searchBtn = document.getElementById("searchBtn");

searchBtn.addEventListener("click", () => {

const city = document.getElementById("cityInput").value;

getWeather(city);

});

async function getWeather(city){

const url =
`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

try{

const response = await fetch(url);

if(!response.ok){

throw new Error("City not found");

}

const data = await response.json();

displayWeather(data);

document.getElementById("error").innerText="";

}catch(error){

document.getElementById("error").innerText=error.message;

}

}

function displayWeather(data){

document.getElementById("city").innerText=data.name;

document.getElementById("temp").innerText=data.main.temp;

document.getElementById("humidity").innerText=data.main.humidity;

document.getElementById("wind").innerText=data.wind.speed;

document.getElementById("condition").innerText=data.weather[0].main;

}
