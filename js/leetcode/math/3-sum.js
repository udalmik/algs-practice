const threeSum = (nums) => {
	const results = []
    
    if (nums.length < 3) 
        return results
    
    nums = nums.sort();

    const target = 0

	for (let i = 0; i < nums.length - 2; i++) {
        
        if (nums[i] > target)
            break;

        if (i > 0 && nums[i] === nums[i - 1])
            continue;
        
        let j = i + 1

		let k = nums.length - 1
		while (j < k) {
            
            const sum = nums[i] + nums[j] + nums[k]

			if (sum === target) {
        
                results.push([nums[i], nums[j], nums[k]])
				while (nums[j] === nums[j + 1] && j < k) j++
				while (nums[k] === nums[k - 1] && j < k) k--
        
                j++
				k--
        
            } else if (sum < target) {
        
                j++
        
            } else {
				k--
			}
		}
	}

	return results
};