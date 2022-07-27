package com.laconic.cb.service.impl;

import com.laconic.cb.model.Booking;
import com.laconic.cb.model.BookingDetail;
import com.laconic.cb.repository.IBookingDetailRepository;
import com.laconic.cb.repository.IBookingRepository;
import com.laconic.cb.service.IBookingService;
import liquibase.util.file.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService implements IBookingService {

    @Value("${server.file.basepath}")
    String filePath;
    private final IBookingRepository bookingRepository;
    private final IBookingDetailRepository bookingDetailRepository;;

    public BookingService(IBookingRepository bookingRepository, IBookingDetailRepository bookingDetailRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingDetailRepository = bookingDetailRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) throws Exception {
        if (booking.getDocument() != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString()+"."+ FilenameUtils.getExtension(booking.getDocument().getOriginalFilename());
            createFile(filePath+"/temp/booking/"+booking.getBookingId()+"/", fileName, booking.getDocument());
        }
        return bookingRepository.save(booking);
    }
    private void createFile(String path, String fileName, MultipartFile multipartFile) throws Exception {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(path + fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(f);) {
            fileOutputStream.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No file");
        }
    }


    @Override
    public BookingDetail saveBookingDetail(BookingDetail bookingDetail) {
        return bookingDetailRepository.save(bookingDetail);
    }

    @Override
    public List<Booking> getBookingList(Long caseId) {
        return bookingRepository.findAllByCaseIdAndIsDeletedFalse(caseId);
    }

    @Override
    public List<BookingDetail> getBookingDetailList(Long bookingId) {
        return bookingDetailRepository.findAllByCaseId(bookingId);
    }

    @Override
    public Optional<Booking> findByCaseId(Long caseId) {
        return bookingRepository.findByCaseId(caseId);
    }

    @Override
    public Optional<Booking> findByBookingId(Long bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }

}
