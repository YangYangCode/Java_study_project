import { useState } from 'react'
import { Button, TextField } from "@mui/material";
import { post_create_classRoom, } from "../../service/Service_AS";

const AddClassRoom = ({ }) => {

    const [formClassRoomInput, setFormClassRoomInput] = useState(     // From 表單
        {
            name: "",
            classRoomSize: ""
        })

    // 修改 formASInput 的資料格式，並傳遞給後端
    const handleSubmit = async () => {
        try {
            console.log(formClassRoomInput);
            const response = await post_create_classRoom(formClassRoomInput);
            console.log(response);
        } catch (error) {
            console.error("Error creating class room:", error);
        }
    };


    return (

        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw] p-4">
                <br></br>
                <br></br>
                <br></br>
                <h2 className="text-4xl font-bold mb-4">新增教室</h2>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    {/* 教室名稱 */}
                    <TextField
                        label="教室名稱"
                        type="text"
                        name="name"
                        value={formClassRoomInput.name}
                        onChange={(event) => setFormClassRoomInput({ ...formClassRoomInput, name: event.target.value })}
                        fullWidth
                    />
                    {/* 教室大小 */}
                    <TextField
                        label="教室大小"
                        type="number"
                        name="classRoomSize"
                        value={formClassRoomInput.classRoomSize}
                        onChange={(event) => setFormClassRoomInput({ ...formClassRoomInput, classRoomSize: event.target.value })}
                        inputProps={{ min: 1, max: 50 }}
                        fullWidth
                    />
                </div>

                {/* 提交按鈕 */}
                <div className="mt-6">
                    <Button variant="contained" color="primary" onClick={handleSubmit}>
                        新增教室
                    </Button>
                </div>
            </div>
        </div>
    );
};


export default AddClassRoom;