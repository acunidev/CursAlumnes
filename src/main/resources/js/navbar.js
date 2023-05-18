document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll('.nav-link').forEach(navLink => {
        if (navLink.href === window.location.href) {
            navLink.classList.add('active');
        }
    });
});