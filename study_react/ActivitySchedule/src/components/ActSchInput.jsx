import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";
import React from "react";

const ActSchInput = ({ ActSch, setActSch, onAdd, FromInput, handleChange, FitnessInstructors, classes, rooms }) => {

  // 函數用於更新 ActSch 的屬性內容
  const changeActSch = (value, field) => {
    setActSch((prevActSch) => ({ ...prevActSch, [field]: value }));
  };


  return (

    <ul style={{ listStyleType: "none"}}>

      <button onClick={onAdd} >新增活動</button>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <FormControl sx={{ m: 1, minWidth: 150 }}>
          <InputLabel id="ActSchformRoomsInput">教室</InputLabel>
          <Select
            labelId="ActSchformRoomsInput"
            id="ActSchformRoomInput"
            value={FromInput}
            onChange={handleChange}
            autoWidth
            label="教室"
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            {rooms.map((room, index) => (
              <MenuItem key={index} value={room}>
                {room}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </li>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <FormControl sx={{ m: 1, minWidth: 150 }}>
          <InputLabel id="ActSchformFitnessInstructorsInput">代課講師</InputLabel>
          <Select
            labelId="ActSchformFitnessInstructorsInput"
            id="ActSchformFitnessInstructorInput"
            value={FromInput}
            onChange={handleChange}
            autoWidth
            label="代課講師"
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            {FitnessInstructors.map((FitnessInstructor, index) => (
              <MenuItem key={index} value={FitnessInstructor}>
                {FitnessInstructor}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </li>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <FormControl sx={{ m: 1, minWidth: 150 }}>
          <InputLabel id="ActSchformclassesInput">課程項目</InputLabel>
          <Select
            labelId="ActSchformclassesInput"
            id="ActSchformclasseInput"
            value={FromInput}
            onChange={handleChange}
            autoWidth
            label="課程項目"
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            {classes.map((class_, index) => (
              <MenuItem key={index} value={class_}>
                {class_}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </li>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <input
          onChange={(e) => changeActSch(e.target.value, "classTime")} // 更新classTime
          value={ActSch.classTime}
          placeholder="請輸入課程時間"
        />
      </li>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <input
          onChange={(e) => changeActSch(e.target.value, "numberOfCanRegister")} // 更新numberOfCanRegister
          value={ActSch.numberOfCanRegister}
          placeholder="請輸入可報名人數"
          type="number" min={1} max={50}
        />
      </li>

      <li style={{ display: "inline", marginRight: "15px" }}>
        <input
          onChange={(e) => changeActSch(e.target.value, "information")} // 更新information
          value={ActSch.information}
          placeholder="請輸入課程細節(information)"
        />
      </li>
      
    </ul>
  );
};

export default ActSchInput;
