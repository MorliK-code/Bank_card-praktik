function redirectTo(url) {
    window.location.href = url;
}
document.addEventListener("DOMContentLoaded", function() {
    var navbarContainer = document.getElementById("navbarContainer");
    var navbar = navbarContainer.querySelector(".navbar");

    var navbarOffsetTop = navbar.offsetTop;

    function updateNavbarPosition() {
        if (window.pageYOffset >= navbarOffsetTop) {
            navbar.classList.add("navbar-fixed");
        } else {
            navbar.classList.remove("navbar-fixed");
        }
    }

    updateNavbarPosition();

    window.addEventListener("scroll", updateNavbarPosition);
});
