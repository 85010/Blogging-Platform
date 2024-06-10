document.addEventListener("DOMContentLoaded", function() {
    if (!localStorage.getItem('popupShown')) {
        document.getElementById('welcome-popup').style.display = 'flex';
        localStorage.setItem('popupShown', 'true');
    }
});

function closePopup() {
    document.getElementById('welcome-popup').style.display = 'none';
}