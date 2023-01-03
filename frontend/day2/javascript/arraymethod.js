// // #1 push - pop - shift - splice        
const nums = [1, 2, 3, 4, 5];

console.log(nums);

nums.push(6);

console.log(nums);

nums.pop(); // 뒤에서 하나 꺼낸다.

console.log(nums);

let num = nums.shift();

console.log(num);
console.log(nums);

nums.splice(2, 1); // index 기반 삭제, 2에서 1개만
console.log(nums)

//#2. slice - join <= return new array
const nums1 = [1, 2, 3, 4, 5];
const nums2 = nums.slice(0, 2);

console.log(nums1); // 그대로
console.log(nums2);


console.log(nums1.slice(3));  // 인덱스 3부터 마지막까지

const nums3 = nums1.join(); // array 를 구분자 기준으로 문자열로, default separator : comma( , )
console.log(nums3);
console.log(nums1);
console.log(nums1.join(' '));
console.log(nums1.join('/'));

//#3 sort() - reverse()
const nums4 = [2, 3, 1, 5, 4];
nums.sort();
console.log(nums4); // 자신이 정렬된다.
nums.reverse();
console.log(nums4);

// #4 forEach - map
const players = ["손흥민", "이강인", "이승우"];

// #4-1. for
for (let i = 0; i < players.length; i++) {
    let player = players[i];
    // do something with player
    console.log(player);
}

// #4-2. foreach with callback
console.warn('');
var print = function (player) {
    console.log(player);
}

players.forEach(print); // print is callback

// #4-3 foreach indexed
players.forEach((player, index) => {
    console.log(player, index);
});

// // #4-5. map ( != Map 자료구조 ) return new array
// console.warn('');
const lastNames = players.map(player => player.charAt(0));
lastNames.forEach(lastName => {
    console.log(lastName);
});

players.map(player => player.charAt(0)).forEach(lastName => {
    console.log(lastName);
});

////////////////////////////////////////////////////////////

// // #5 filter 조건에 맞는 항목만으로 return new array
console.warn('');
const words = ['aaa', 'bbbb', 'ccc', 'ddddd', 'ee', 'fffff'];
const result = words.filter(word => word.length > 3);
console.log(result);

///// 배열에서 어떤 계산된 값을 얻고자 할 때
console.warn('');
const nums8 = [3, 2, 7, 4, 9, 6];

// sum
const sum = nums8.reduce((acc, cur) => acc += cur);
console.log(sum);

// min
const min = nums8.reduce((acc, cur) => acc = acc <= cur ? acc : cur);
console.log(min);

// max
const max = nums8.reduce((acc, cur) => acc = acc >= cur ? acc : cur);
console.log(max);