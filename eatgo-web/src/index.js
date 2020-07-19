(async() => {
    const url = "http://localhost:8080/restaurants";
    const response = await fetch(url);
    const restauarants = await response.json();

    const element = document.getElementById("app");
    element.innerHTML = `
        ${restauarants.map(restauarant => `
            <p>
            ${restauarant.id}
            ${restauarant.name}
            ${restauarant.address}
        </p>
        `).join(' ')}
    `;
})();