import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";
import React from "react";

const FormClass = ({ ActSch, setActSch, onAdd, handleChange, FitnessInstructors, classes, rooms }) => {


    const changeActSch = (value, field) => {
        setActSch((prevActSch) => ({ ...prevActSch, [field]: value }));
    };

    return (
        <li>
            <FormControl sx={{ m: 1, minWidth: 80 }}>
                <InputLabel id="ActSchformRoomsInput">教室</InputLabel>
                <Select
                    labelId="ActSchformRoomsInput"
                    id="ActSchformRoomInput"
                    value={FromInput}
                    onChange={handleChange}
                    autoWidth
                    label="教室"
                    placeholder="請選擇教室"
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
    )
    
}

    export default FormClass;