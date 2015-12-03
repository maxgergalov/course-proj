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
    self.howUsers = ko.observable("5")
    self.howOffers = ko.observable("3")
    self.Activate = function(){
        $.get("/test/qwe", function(json){
            self.howOffers(json.howOffers)
            self.howUsers(json.howUsers)
            self.offers(json.adminOffers)
            self.users(json.allUsers)
        })
    }
    self.offers = ko.observableArray([])
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

}

$(function(){
//	$.ajax({
//
//        url: 'howOffers',
//        type: "POST",
//        dataType: "json",
//        contentType: "application/json; charset=utf-8",
//        data: JSON.stringify(json),
//        success: function HowOffersModel() {
//            alert("yeah, this is success baby")
//        }
//    });
    var vm = new ViewModel();
    ko.applyBindings(vm)
    vm.Activate()
});



