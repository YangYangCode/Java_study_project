import { useState, useEffect } from 'react'
import { Autocomplete, Button, Chip, FormControl, InputLabel, MenuItem, Select, TextareaAutosize, TextField } from "@mui/material";
import { get_all_classType, get_all_classRoom, get_all_fitnessInstructor, get_all_activityManager, post_create_activitySchedule, } from "../service/Service_AS";

const AddAS = ({ }) => {

    const [formASInput, setFormASInput] = useState(     // From 表單
        {
            date: "",
            classTime: "",
            maxSignNumber: "",
            information: "",
            activityManager: "",
            classRoom: "",
            classType: "",
            fitnessInstructors: []
        })

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


    // 定義狀態來儲存從 API 獲得的活動資料
    const [classRooms, setClassRooms] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const CRList = await get_all_classRoom();
                setClassRooms(CRList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getAllClassRooms:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次


    // 定義狀態來儲存從 API 獲得的活動資料
    const [activityManagers, setActivityManagers] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const AMList = await get_all_activityManager();
                setActivityManagers(AMList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getAllAM:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次


    // 定義狀態來儲存從 API 獲得的活動資料
    const [fitnessInstructors, setFitnessInstructors] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const FIList = await get_all_fitnessInstructor();
                setFitnessInstructors(FIList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getFitnessInstructors:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(fitnessInstructors);  // 注意： 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次


    const timePeriods = [
        "08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00",
        "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00",
        "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00"];

    // 計算今天和60天後的日期
    const today = new Date();
    const maxDate = new Date();
    maxDate.setDate(today.getDate() + 60);

    // 將日期格式化為 YYYY-MM-DD
    const formatDate = (date) => {
        return date.toISOString().split("T")[0];
    };

    // 修改 formASInput 的資料格式，並傳遞給後端
    const handleSubmit = async () => {
        // 將 fitnessInstructors 轉換為 Map(Long, String) 格式
        const fitnessInstructorsMap = formASInput.fitnessInstructors.reduce((map, instructor) => {
            map[instructor.id] = instructor.name;  // 使用教練的 ID 作為鍵，名稱作為值
            return map;
        }, {});
    
        const formattedData = {
            date: formASInput.date,
            classTime: formASInput.classTime,
            maxSignNumber: formASInput.maxSignNumber,
            information: formASInput.information,
            activityManager: formASInput.activityManager,
            classRoom: formASInput.classRoom,
            classType: formASInput.classType,
            fitnessInstructors: fitnessInstructorsMap  // 傳遞 Map 格式
        };
    
        try {
            console.log(formattedData);
            const response = await post_create_activitySchedule(formattedData);
            console.log(response);
        } catch (error) {
            console.error("Error creating activity schedule:", error);
        }
    };
    



    return (
        <div className="p-4">
            <h2 className="text-xl font-bold mb-4">新增活動</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                {/* 日期輸入 */}
                <TextField
                    label="日期"
                    type="date"
                    name="date"
                    value={formASInput.date}
                    onChange={(event) => setFormASInput({ ...formASInput, date: event.target.value })}
                    InputLabelProps={{ shrink: true }}
                    inputProps={{
                        min: formatDate(today), // 最早日期
                        max: formatDate(maxDate) // 最晚日期
                    }}
                    fullWidth
                />

                {/* 課程時段 */}
                <FormControl sx={{ minWidth: 200 }}>
                    <InputLabel id="classTimeLabel">課程時段</InputLabel>
                    <Select
                        labelId="classTimeLabel"
                        id="classTime"
                        value={formASInput.classTime}
                        onChange={(event) => setFormASInput({ ...formASInput, classTime: event.target.value })}
                        autoWidth
                        label="課程時段"
                    >
                        <MenuItem value="">
                            <em>None</em>
                        </MenuItem>
                        {timePeriods.map((time, index) => (
                            <MenuItem key={index} value={time}>
                                {time}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>

                {/* 在 Autocomplete component 中直接使用 fitnessInstructors */}
                <Autocomplete
                    multiple
                    id="fitnessInstructors"
                    options={fitnessInstructors} // 直接使用教練列表
                    getOptionLabel={(option) => option.username} // 顯示教練名稱 (假設 `username` 是名稱字段)
                    value={formASInput.fitnessInstructors} // 確保這是陣列
                    onChange={(event, newValue) => {
                        setFormASInput({ ...formASInput, fitnessInstructors: newValue }); // 更新選中的教練
                    }}
                    renderTags={(value, getTagProps) =>
                        value.map((option, index) => (
                            <Chip
                                key={option.id}  // 將 key 放到 Chip 元素上
                                label={option.username}  // 顯示教練名稱
                                {...getTagProps({ index })}  // 其他屬性
                            />
                        ))
                    }
                    renderInput={(params) => (
                        <TextField
                            {...params}
                            label="帶課教練"
                            placeholder="選擇教練"
                            fullWidth
                        />
                    )}
                />

                {/* 課程項目 */}
                <FormControl fullWidth>
                    <InputLabel>課程項目</InputLabel>
                    <Select
                        name="classType"
                        value={formASInput.classType}
                        onChange={(event) => setFormASInput({ ...formASInput, classType: event.target.value })}
                    >
                        <MenuItem value="">
                            <em>None</em>
                        </MenuItem>
                        {classTypes.map((type) => (
                            <MenuItem key={type.id} value={type}>
                                {type.name}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>

                {/* 教室 */}
                <FormControl fullWidth>
                    <InputLabel>上課教室</InputLabel>
                    <Select
                        name="classRoom"
                        value={formASInput.classRoom}
                        onChange={(event) => setFormASInput({ ...formASInput, classRoom: event.target.value })}
                    >
                        <MenuItem value="">
                            <em>None</em>
                        </MenuItem>
                        {classRooms.map((room) => (
                            <MenuItem key={room.id} value={room}>
                                {room.name}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>

                {/* 可報名人數 */}
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
                        <MenuItem value="">
                            <em>None</em>
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
                    新增活動
                </Button>
            </div>
        </div>
    );
};


export default AddAS;