function insert(arr, item, index) {
    var narr=[];
    for (var i = 0; i <arr.length; i++) {
        if (i<index){
            narr[i]=arr[i];
        } else if (i==index){
            narr[i]=item;
        } else {
            narr[i]=arr[i-1];
        }
    }
    narr[arr.length]=arr[arr.length-1]
    return narr;
}