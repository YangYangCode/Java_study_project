import React from "react";

const ActSchInput = ({ ActSch, setActSch, onAdd }) => {

    // {id: 1, 
    //  room: 101, 
    //  FitnessInstructor: 29, 
    //  class: "空中瑜珈", 
    //  numberOfCanRegister: 20, 
    //  numberOfHaveSigned: 6, 
    //  classTime: "2024,11,19 11-00-00", 
    //  information: "information",
    //  memberHaveSigned: ["a", "b", "c", "d", "e", "f"]},

  // 函數用於更新 ActSch 的屬性內容
  const changeActSch = (value, field) => {
    setActSch((prevActSch) => ({...prevActSch,[field]: value}));
  };

  return (
    <div>
      <input
        onChange={(e) => changeActSch(e.target.value, "room")} // 更新room
        value={ActSch.room}
        placeholder="請輸入教室編號(room_id)"
      />

      <input
        onChange={(e) => changeActSch(e.target.value, "FitnessInstructor")} // 更新FitnessInstructor
        value={ActSch.FitnessInstructor}
        placeholder="請輸入講師編號(FitnessInstructor_id)"
      />
      
      <input
        onChange={(e) => changeActSch(e.target.value, "class")} // 更新class
        value={ActSch.class}
        placeholder="請輸入課堂名稱(className)"
      />      

      <input
        onChange={(e) => changeActSch(e.target.value, "classTime")} // 更新classTime
        value={ActSch.classTime}
        placeholder="請輸入課程時間"
      />

      <input
        onChange={(e) => changeActSch(e.target.value, "numberOfCanRegister")} // 更新numberOfCanRegister
        value={ActSch.numberOfCanRegister}
        placeholder="請輸入可報名人數"
      />

      <input
        onChange={(e) => changeActSch(e.target.value, "numberOfHaveSigned")} // 更新numberOfHaveSigned
        value={ActSch.texnumberOfHaveSignedt}
        placeholder="目前已報名人數(f)"
      />
            
      <input
        onChange={(e) => changeActSch(e.target.value, "information")} // 更新information
        value={ActSch.information}
        placeholder="請輸入課程細節(information)"
      />
            
      <input
        onChange={(e) => changeActSch(e.target.value, "memberHaveSigned")} // 更新memberHaveSigned
        value={ActSch.memberHaveSigned}
        placeholder="已報名人員列表"
      />

      <button onClick={onAdd} >新增活動</button>

    </div>
  );
};

export default ActSchInput;
