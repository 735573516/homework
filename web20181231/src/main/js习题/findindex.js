function findAllOccurrences(arr, target) {
    var narr=[];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i]==target){
            narr.push(i)
        }
    }
    return narr
}