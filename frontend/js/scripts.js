async function getMusiccreators() {
	console.log("patata");
	const response = await fetch("http://localhost:8080/api/musiccreators");
	const musiccreators = await response.json();
	let mc = document.getElementById("mc");
	mc.innerHTML= musiccreators[0].name;
}

getMusiccreators();