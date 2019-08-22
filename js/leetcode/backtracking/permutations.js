/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    let result = [[]];
    nums.forEach(n => {
        result = permuteWithNum(result, n);
    })
    return result
};

const permuteWithNum = (permutations, num) => {
    const result = [];
    permutations.forEach(arr => {
        for (let i = 0; i < arr.length; i++) {
            result.push([
                ...arr.slice(0, i),
                num,
                ...arr.slice(i)
            ]);
        }
        result.push([...arr, num]);
    });
    return result;
}


const permuteBacktrack = nums => {
    const res = [];

    const _permute = (nums, start) => {
        if (nums.length - 1 === start) {
            res.push([...nums]);
        } else {
            for (let i = start; i < nums.length; i++) {
                swap(nums, i, j);
                _permute(nums, start + 1);
                swap(nums, i, j);
            }
        }
    }
    _permute(nums, 0);
    return res;
}

const swap = (nums, i, j) => {
    const temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

