document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".announcement-form");
    const titleInput = form.querySelector("input[name='title']");

    form.addEventListener("submit", function (event) {
        const title = titleInput.value.trim();

        if (/^\d/.test(title)) {
            event.preventDefault();
            alert("Title should not start with a number.");
            titleInput.classList.add("input-error");
            titleInput.focus();
        } else {
            titleInput.classList.remove("input-error");
        }
    });
});

