com_company_slider_javascript_Slider = function () {
    let currentImageIndex = 0;
    const img1 = document.querySelector('.v-slot-img1');
    const img2 = document.querySelector('.v-slot-img2');
    const img3 = document.querySelector('.v-slot-img3');
    const images = [img1, img2, img3];


    const arrowLeft = document.querySelector('.v-slot-arrowLeft');
    const arrowRight = document.querySelector('.v-slot-arrowRight');

    function showCurrentImage() {

        images.forEach((image, index) => {
            if (index === currentImageIndex) {
                image.classList.remove('hidden');
                image.classList.add('active');
            } else {
                image.classList.remove('active');
                image.classList.add('hidden');
            }
        });
    }

    function changeImage(direction) {
        currentImageIndex += direction;


        if (currentImageIndex >= images.length) {
            currentImageIndex = 0;
        }

        if (currentImageIndex < 0) {
            currentImageIndex = images.length - 1;
        }

        showCurrentImage();
    }

    arrowLeft.addEventListener('click', () => changeImage(-1));
    arrowRight.addEventListener('click', () => changeImage(1));

    showCurrentImage();
}
