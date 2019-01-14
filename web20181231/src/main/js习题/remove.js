function remove(arr, item) {
    var narr=[];
    for (var i = 0; i <arr.length; i++) {
        if (arr[i]!=item) {
            narr.push(arr[i]);
        }
    }
    return narr;
}