document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form[action='updatefaqs']");
    const nameInput = document.getElementById("name");

    form.addEventListener("submit", function (event) {
        const nameValue = nameInput.value.trim();

        
        if (/^\d/.test(nameValue)) {
            alert("Question should not start with a number.");
            nameInput.focus();
            event.preventDefault(); 
        }
    });
});
