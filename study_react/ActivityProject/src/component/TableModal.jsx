import React, { useState } from 'react';
import { Dialog, DialogTitle, DialogContent, DialogActions, Button, Box } from '@mui/material';

// 通用模態視窗組件
const TableModal = ({}) => {

    // 放頁面 
        // 觸發按鈕
        const [openModal, setOpenModal] = useState(false);  // 控制模態視窗開關
        // model 內容
        const [modalContent, setModalContent] = useState('');  // 儲存模態視窗內容

    // 放按鈕
        // 開啟模態視窗
        const handopenModal = (content) => {
            // console.log(content);
            setModalContent(content);
            setOpenModal(true);
        };



    return (
        <Dialog open={openModal} onClose={() => setOpenModal(false)}>
            <DialogTitle>詳細內容</DialogTitle>
            <DialogContent>
                <Box>{modalContent}</Box>
            </DialogContent>
            <DialogActions>
                <Button onClick={() => setOpenModal(false)} color="primary">
                    關閉
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default TableModal;