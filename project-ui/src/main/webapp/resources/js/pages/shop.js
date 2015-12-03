$(document).ready(function () {
    $('.offerRatingFixed').raty({
        score: function () {
            return $(this).attr('data-score');
        },
        halfScore: true,
        path: '/resources/img/raty/',
        readOnly: true
    });

    $('.offerRating').raty({
        score: function () {
            return $(this).attr('data-score');
        },
        halfScore: true,
        path: '/resources/img/raty/',
        click: function (score, evt) {
            var offerId = $('#offerId').val();
            var json = {'offerId': offerId, 'bind': score};
            var new_data = 5;
            var that = this;
            $.ajax({
                url: 'addofferrate',
                type: "POST",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(json),
                success: function (new_rate) {
                    if (new_rate > 0) {
                        $(that).raty('score', new_rate);
                        $(that).raty('readOnly', true);
                    } else {
                        $(that).raty('score', $(that).raty('score'));
                        $(that).raty('readOnly', true);
                    }

                }
            });
        }
    });
});

function makeDeal(offerId){
    $.ajax({
        url: '/offer/'+offerId+'/deal',
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            alert("responce");
}
    });
}