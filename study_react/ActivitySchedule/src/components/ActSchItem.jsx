import React from 'react';

const ActSchItem = ({ ActSch }) => {
return (
    <li>
        <span>{ActSch.id}, </span> 
        <span>教室: {ActSch.room}　</span>
        <span>講師: {ActSch.FitnessInstructor}　</span>
        <span>課程: {ActSch.class}　</span>
        <span>課程時間: {ActSch.classTime}　</span>
        <span>人數: {ActSch.numberOfCanRegister}/{ActSch.numberOfHaveSigned}(人)　</span>
        <button>詳細內容</button>
        <button>報名人員清單</button>
    </li>
    );
};

export default ActSchItem;