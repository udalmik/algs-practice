
const delimeter = ";";
const nullMarker = 'N';

var serialize = function(root, curr = "") {
    if (!root) {
        curr += `${nullMarker}${delimeter}`;
        return curr;
    }
    curr += `${root.val}${delimeter}`
    curr = serialize(root.left, curr);
    curr = serialize(root.right, curr);
    return curr;
}

var deserialize = function(data) {
    return deserializeFromArray(data.split(delimeter));
}

var deserializeFromArray = function(arr) {
    if (arr.length === 0) {
        return null;
    }        
    const val = arr.shift();
    if (val === nullMarker) {
        return null;
    }
    return {
        val: Number(val),
        left: deserializeFromArray(arr),
        right: deserializeFromArray(arr)
    };
}

module.exports = {
    deserialize,
    serialize
}