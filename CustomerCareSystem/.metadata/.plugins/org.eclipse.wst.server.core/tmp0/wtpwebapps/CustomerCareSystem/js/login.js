document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const usernameInput = document.getElementById("uid");

    form.addEventListener("submit", function (event) {
        const username = usernameInput.value;

        if (username.includes(" ")) {
            event.preventDefault();
            alert("Username should not contain spaces.");
            usernameInput.focus();
        }
    });
});
