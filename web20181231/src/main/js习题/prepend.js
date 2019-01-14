function prepend(arr, item) {
    var narr=[];
    narr[0]=item
    for (var i =0; i <arr.length; i++) {
        narr[i+1]=arr[i]
    }
    return narr;
}