import { useState, useEffect } from 'react'
import { Autocomplete, Button, Chip, FormControl, InputLabel, MenuItem, Select, TextareaAutosize, TextField } from "@mui/material";
import {
    get_all_classType, get_all_classRoom, get_all_fitnessInstructor, get_all_activityManager,
    update_activitySchedule_by_id,
} from "../../service/Service_AS";
import { useLocation } from "react-router-dom";

const updateClassRoom = ({ }) => {

    // 获取传递的活动信息
    const location = useLocation();
    const { item } = location.state || {};  // 这里是你通过 state 传递的活动信息

    // 定義狀態來儲存從 API 獲得的活動資料
    const [classTypes, setClassTypes] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const CTList = await get_all_classType();
                setClassTypes(CTList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getClassTypes:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(fitnessInstructors);  // 注意： 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次

    const [formASInput, setFormASInput] = useState(     // From 表單
        {
            id: item.id,
            name: item.name,
            classType: item.classType,
        })


    // 修改 formASInput 的資料格式，並傳遞給後端
    const handleSubmit = async () => {
        try {
            console.log(formattedData);
            const response = await update_activitySchedule_by_id(formASInput.id, formattedData);
            console.log(response);
        } catch (error) {
            console.error("Error update activity schedule:", error);
        }
    };


    return (

        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw] p-4">
                <br></br>
                <br></br>
                <br></br>
                <h2 className="text-4xl font-bold mb-4">修改活動</h2>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    
                    {/* 人數上限 */}
                    <TextField
                        label="報名人數上限"
                        type="number"
                        name="maxSignNumber"
                        value={formASInput.maxSignNumber}
                        onChange={(event) => setFormASInput({ ...formASInput, maxSignNumber: event.target.value })}
                        inputProps={{ min: 1, max: 50 }}
                        fullWidth
                    />

                    {/* 活動負責人 */}
                    <FormControl fullWidth>
                        <InputLabel>活動管理員</InputLabel>
                        <Select
                            name="activityManagers"
                            value={formASInput.activityManager}
                            onChange={(event) => setFormASInput({ ...formASInput, activityManager: event.target.value })}
                        >
                            <MenuItem value={formASInput.activityManager}>
                                <em>{formASInput.activityManager.name}</em>
                            </MenuItem>
                            {activityManagers.map((manager) => (
                                <MenuItem key={manager.id} value={manager}>
                                    {manager.name}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                </div>

                {/* 課程細節 */}
                <div className="mt-4">
                    <label className="block text-sm font-medium text-gray-700 mb-2">課程細節</label>
                    <TextareaAutosize
                        minRows={6}
                        placeholder="請輸入課程細節 (information)"
                        name="information"
                        value={formASInput.information}
                        onChange={(event) => setFormASInput({ ...formASInput, information: event.target.value })}
                        className="w-full border border-gray-300 rounded p-2 focus:ring focus:ring-blue-300"
                    />
                </div>

                {/* 提交按鈕 */}
                <div className="mt-6">
                    <Button variant="contained" color="primary" onClick={handleSubmit}>
                        更新活動
                    </Button>
                </div>
            </div>
        </div>
    );
};

export default updateClassRoom;