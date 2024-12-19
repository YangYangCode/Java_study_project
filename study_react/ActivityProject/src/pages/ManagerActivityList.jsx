import React, { useState, useEffect } from "react";
import ActivityScheduleDataTable from "../component/AS_DataTable";
import { get_all_activitySchedule } from "../service/Service_AS";
import { Box, Button, Dialog, DialogActions, DialogContent, DialogTitle } from "@mui/material";


function ManagerActivityList() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [activities, setActivities] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const ASList = await get_all_activitySchedule();
                setActivities(ASList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getAllAS:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次


    // Modal
    // 觸發按鈕
    const [isModalopen, setIsModalopen] = useState(false);  // 控制模態視窗開關
    // model 內容
    const [modalContent, setModalContent] = useState('');  // 儲存模態視窗內容

    // 放按鈕
    // 開啟模態視窗
    const handIsModalopen = (content) => {
        // console.log(content);
        setModalContent(content);
        setIsModalopen(true);
    };

    return (

        <div>
            {/* DataTable */}
            <div>
                <h1 className="text-6xl text-center font-semibold mb-2">活動清單</h1>
                <ActivityScheduleDataTable activities={activities} handIsModalopen={handIsModalopen} setModalContent={setModalContent} />
            </div>

            {isModalopen && (
                <Dialog open={isModalopen} onClose={() => setIsModalopen(false)}
                    fullWidth maxWidth="md">
                    <Box className="bg-white p-6 rounded shadow-lg text-center">
                        <DialogContent>
                            <Box>
                                {Array.isArray(modalContent) ? ( // 如果 modalContent 是一個陣列（如簽到會員列表）
                                    <table className="table-auto w-full border-collapse border border-gray-300">
                                        <thead>
                                            <tr>
                                                <th className="border border-gray-300 px-4 py-2">會員編號</th>
                                                <th className="border border-gray-300 px-4 py-2">會員名稱</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {modalContent.map(({ id, name }) => (
                                                <tr key={id}>
                                                    <td className="border border-gray-300 px-4 py-2">{id}</td>
                                                    <td className="border border-gray-300 px-4 py-2">{name}</td>
                                                </tr>
                                            ))}
                                        </tbody>
                                    </table>
                                ) : typeof modalContent === "string" ? ( // 如果 modalContent 是字符串（如簡單信息）
                                    <div>
                                        <h1 className="2xl px-4 py-2">活動資訊</h1>
                                        <br></br>
                                        <p>{modalContent}</p>
                                    </div>
                                ) : ( // 如果 modalContent 是未知類型
                                    <p>無法顯示的內容格式</p>
                                )}
                            </Box>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={() => setIsModalopen(false)} color="primary" variant="contained" >
                                關閉
                            </Button>
                        </DialogActions>
                    </Box>
                </Dialog>
            )}

        </div>



    )
}

export default ManagerActivityList;