document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".faq-form form");
    const nameInput = form.querySelector("input[name='name']");

    form.addEventListener("submit", function (event) {
        const nameValue = nameInput.value.trim();

        
        if (/^\d/.test(nameValue)) {
            alert("Question should not start with a number.");
            nameInput.focus();
            event.preventDefault(); 
        }
    });
});
