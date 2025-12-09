document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".ticket-section");
    const subjectInput = form.querySelector("input[name='subject']");

    form.addEventListener("submit", function (event) {
        const subject = subjectInput.value.trim();

        if (/\d/.test(subject)) {
            event.preventDefault();
            alert("Subject should not contain any numbers.");
            subjectInput.classList.add("input-error");
            subjectInput.focus();
        } else {
            subjectInput.classList.remove("input-error");
        }
    });
});
