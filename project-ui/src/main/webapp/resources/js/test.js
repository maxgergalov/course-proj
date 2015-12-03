$.ajaxSetup({
    cache: false
});

var $post = function(url, data, cb){
    return jQuery.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 600000,
        success: cb
    });
}
var ViewModel = function (){
    var self = this
    self.howUsers = ko.observable("")
    self.howOffers = ko.observable("")
    self.title = ko.observable()
    self.description = ko.observable()
    self.price = ko.observable()

    self.Activate = function(){

        $.get("/test/qwe", function(json){

        	
            self.howOffers(json.howOffers)
            self.howUsers(json.howUsers)
            debugger
            self.offers(json.adminOffers)
            self.users(json.allUsers)
            
            var offers = ko.utils.arrayMap(json.lastOffers, function(o){
            	var  r = o.offer;
            	r.commentsCount = o.commentsCount; 
            	r.mainImageUrl = o.mainImageUrl;
            	r.rating = o.rating;
            	r.id = o.offer.id;
            	return r;
            })
            self.lastOffers(offers)
        })
        // $.get("/test/shop", function(json){
        // 	self.lastOffers(json.lastOffers)
            
        // })
    }
    
    self.offers = ko.observableArray([])
    self.users= ko.observableArray([])
    self.lastOffers = ko.observableArray([])

    self.save = function(item){

        $post("/test/save", { id: item.id, title:item.title, description : item.description},function(){

        });
       /* $.post("/test/save", {Id: item.Id, description:item.description}, function(){
            debugger
        })*/
    }
    self.delete = function(item){
        $post("/test/delete", {id:item.id}, function(){
            self.offers.remove(item)
        })

    }
    self.saveUser = function(item){
    	

        $post("/test/saveUser", { id: item.id, name:item.name, mail:item.mail, password: item.password},function(){
        	alert("User ~ " + item.name + " ~  has been changed" )
        });
       /* $.post("/test/save", {Id: item.Id, description:item.description}, function(){
            debugger
        })*/
    }
    self.deleteUser = function(item){
        $post("/test/deleteUser", {id:item.id}, function(){
            self.users.remove(item)
        })

    }
    self.create = function(){
    	if (uploadedFile){
                var formData = new FormData();
                formData.append('textbox', uploadedFile)
                formData.append('title', self.title())
                formData.append('description', self.description())
                formData.append('price', self.price())
                $.ajax({
                    type: 'POST',
                    url: '/createOffer/create' ,
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {

                        debugger
                        uploadedFile = null;
                       // self.selectedMember().avatar(null);
                       // console.log("success");
                       // console.log(data);
                       window.location="/shop"
                    },
                    error: function (data) {
                        //???java call error
                        //debugger
                        uploadedFile = null;
                       // console.log("error");
                       // console.log(data);
                    }
                });
            }
    }
   var uploadedFile;
        self.changePhoto = function(file){

            var fileReader = new FileReader();
            fileReader.onload = function(a, b, c){
                uploadedFile = file;
            }

            fileReader.readAsDataURL(file);
        }

}

/*$(document).ready(function () {
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
            var json = {'offerId': offerId, 'score': score};
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
*/
$(function(){
    var vm = new ViewModel();
    ko.applyBindings(vm)
    vm.Activate()
});



